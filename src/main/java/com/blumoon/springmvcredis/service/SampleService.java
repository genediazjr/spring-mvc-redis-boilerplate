/*
 *   Blumoon Technologies Corp.
 *   Copyright 2013.
 */
package com.blumoon.springmvcredis.service;

import com.blumoon.springmvcredis.keys.SetKeys;
import com.blumoon.springmvcredis.keys.StringKeys;
import com.blumoon.springmvcredis.util.KeysUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gene Diaz Jr. <gene@blumoon.mobi>
 */
@Service
public class SampleService {

    private static final Log LOG = LogFactory.getLog(SampleService.class);
    @Autowired
    private StringRedisTemplate template;

    public Object sample(String sample) {

        KeysUtil keysUtil = new KeysUtil();

        // generate id
        String sampleId = keysUtil.generateUUID();

        // check from set if id exists
        if (template.opsForSet().isMember(SetKeys.SAMPLE, sampleId)) {
            // regenerate id
            sampleId = keysUtil.generateUUID();
        }

        // add id to set and check if added
        if (1 == template.opsForSet().add(SetKeys.SAMPLE, sampleId)) {

            // set next object if id was added
            boolean result = template.opsForValue().setIfAbsent(keysUtil.build(StringKeys.SAMPLE, sampleId), sample);

            LOG.debug(new StringBuilder("SampleId: ")
                    .append(sampleId).append(" Value: ")
                    .append(sample).append(" Result: ")
                    .append(result));
        }

        return sampleId;
    }

}
