/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.elasticjob.lite.api.job;

import org.apache.shardingsphere.elasticjob.lite.executor.ShardingContexts;
import org.apache.shardingsphere.elasticjob.lite.fixture.ShardingContextsBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class ShardingContextTest {
    
    @Test
    public void assertNew() {
        ShardingContexts shardingContexts = ShardingContextsBuilder.getMultipleShardingContexts();
        ShardingContext actual = new ShardingContext(shardingContexts, 1);
        assertThat(actual.getJobName(), is(shardingContexts.getJobName()));
        assertThat(actual.getTaskId(), is(shardingContexts.getTaskId()));
        assertThat(actual.getShardingTotalCount(), is(shardingContexts.getShardingTotalCount()));
        assertThat(actual.getJobParameter(), is(shardingContexts.getJobParameter()));
        assertThat(actual.getShardingItem(), is(1));
        assertThat(actual.getShardingParameter(), is(shardingContexts.getShardingItemParameters().get(1)));
    }
    
    @Test
    public void assertToString() {
        assertThat(new ShardingContext(ShardingContextsBuilder.getMultipleShardingContexts(), 1).toString(), 
                is("ShardingContext(jobName=test_job, taskId=fake_task_id, shardingTotalCount=2, jobParameter=, shardingItem=1, shardingParameter=B)"));
    }
}
