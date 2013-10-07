/*
 *   Blumoon Technologies Corp.
 *   Copyright 2013.
 */
package com.blumoon.springmvcredis.rest;

import com.blumoon.springmvcredis.service.SampleService;
import com.blumoon.springmvcredis.util.GenericUtil;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Gene Diaz Jr. <gene@blumoon.mobi>
 */
@Controller
@RequestMapping("/sample")
public class SampleREST {

    private static final Log LOG = LogFactory.getLog(SampleREST.class);
    @Autowired
    private SampleService sampleService;

    /*
     * Sample controller
     */
    @RequestMapping(value = "/test/{SAMPLE}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String sample(
            @PathVariable("SAMPLE") String sample,
            HttpServletResponse response) throws IOException {

        GenericUtil util = new GenericUtil();

        // sample validation
        if (util.isNotNumpty(sample)) {

            // send to service
            String sampleId = (String) sampleService.sample(sample);

            LOG.debug(new StringBuilder("Sample: ")
                    .append(sample));

            return sampleId;
        }

        response.sendError(HttpServletResponse.SC_NOT_FOUND);
        return null;
    }
}
