/*
 * Copyright 2011-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.redis.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Hash operations bound to a certain key.
 *
 * @author Costin Leau
 * @author Christoph Strobl
 * @author Ninad Divadkar
 * @author Mark Paluch
 */
public interface BoundHashOperations<H, HK, HV> extends BoundKeyOperations<H> {

	/**
	 * Delete given hash {@code keys} at the bound key.
	 *
	 * @param keys must not be {@literal null}.
	 * @return
	 */
	Long delete(Object... keys);

	/**
	 * Determine if given hash {@code key} exists at the bound key.
	 *
	 * @param key must not be {@literal null}.
	 * @return
	 */
	Boolean hasKey(Object key);

	/**
	 * Get value for given {@code key} from the hash at the bound key.
	 *
	 * @param key must not be {@literal null}.
	 * @return
	 */
	HV get(Object key);

	/**
	 * Get values for given {@code keys} from the hash at the bound key.
	 *
	 * @param keys must not be {@literal null}.
	 * @return
	 */
	List<HV> multiGet(Collection<HK> keys);

	/**
	 * Increment {@code value} of a hash {@code key} by the given {@code delta} at the bound key.
	 *
	 * @param key must not be {@literal null}.
	 * @param delta
	 * @return
	 */
	Long increment(HK key, long delta);

	/**
	 * Increment {@code value} of a hash {@code key} by the given {@code delta} at the bound key.
	 *
	 * @param key must not be {@literal null}.
	 * @param delta
	 * @return
	 */
	Double increment(HK key, double delta);

	/**
	 * Get key set (fields) of hash at the bound key.
	 *
	 * @return
	 */
	Set<HK> keys();

	/**
	 * Get size of hash at the bound key.
	 *
	 * @return
	 */
	Long size();

	/**
	 * Set multiple hash fields to multiple values using data provided in {@code m} at the bound key.
	 *
	 * @param m must not be {@literal null}.
	 */
	void putAll(Map<? extends HK, ? extends HV> m);

	/**
	 * Set the {@code value} of a hash {@code key} at the bound key.
	 *
	 * @param key must not be {@literal null}.
	 * @param value
	 */
	void put(HK key, HV value);

	/**
	 * Set the {@code value} of a hash {@code key} only if {@code key} does not exist.
	 *
	 * @param key must not be {@literal null}.
	 * @param value
	 * @return
	 */
	Boolean putIfAbsent(HK key, HV value);

	/**
	 * Get entry set (values) of hash at the bound key.
	 *
	 * @return
	 */
	List<HV> values();

	/**
	 * Get entire hash at the bound key.
	 *
	 * @return
	 */
	Map<HK, HV> entries();

	/**
	 * Use a {@link Cursor} to iterate over entries in the hash.
	 *
	 * @param options
	 * @return
	 * @since 1.4
	 */
	Cursor<Map.Entry<HK, HV>> scan(ScanOptions options);

	/**
	 * @return
	 */
	RedisOperations<H, ?> getOperations();
}
