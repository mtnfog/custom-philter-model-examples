package com.mtnfog.philter.service;

import com.mtnfog.philter.opennlp.OpenNlpNer;
import com.mtnfog.philter.opennlp.PhilterSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ModelServiceController {

    @Autowired
    private OpenNlpNer openNlpNer;

    @RequestMapping(value = "/process", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<PhilterSpan> process(@RequestBody String text) {
        return openNlpNer.extract(text);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public ResponseEntity<String> status() {
        return new ResponseEntity<String>("healthy", HttpStatus.OK);
    }

}
