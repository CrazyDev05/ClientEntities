package de.cubbossa.dontshade.cliententities;

import javax.annotation.concurrent.ThreadSafe;
import java.util.TreeSet;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@ThreadSafe
public class EntityIdProvider implements EntityIdGenerator {

  private static final EntityIdGenerator provider = new EntityIdProvider();

  public static EntityIdGenerator get() {
    return provider;
  }

  private final ReadWriteLock lock = new ReentrantReadWriteLock();
  private int entityId;
  private final TreeSet<Integer> freeIds;

  public EntityIdProvider() {
    this((int) 1e5);
  }

  public EntityIdProvider(int startId) {
    this.entityId = startId;
    this.freeIds = new TreeSet<>();
  }

  @Override
  public boolean isClaimed(int id) {
    lock.readLock().lock();
    boolean val = id < entityId || !freeIds.contains(id);
    lock.readLock().unlock();
    return val;
  }

  @Override
  public int nextEntityId() {
    lock.writeLock().lock();
    Integer present = freeIds.pollFirst();
    if (present == null) {
      return entityId--;
    }
    lock.writeLock().unlock();
    return present;
  }

  @Override
  public void releaseEntityId(int id) {
    lock.writeLock().lock();
    freeIds.add(id);
    lock.writeLock().unlock();
  }
}
