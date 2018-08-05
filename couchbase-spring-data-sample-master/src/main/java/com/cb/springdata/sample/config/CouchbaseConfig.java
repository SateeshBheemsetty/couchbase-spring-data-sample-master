package com.cb.springdata.sample.config;

import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import java.util.Arrays;
import java.util.List;

public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList("localhost");
    }

    @Override
    protected String getBucketName() {
        return "sampleBucket";
    }

    @Override
    protected String getBucketPassword() {
        return "sampleBucket";
    }
}
