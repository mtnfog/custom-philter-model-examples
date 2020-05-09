package com.mtnfog.philter.opennlp;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.Span;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class OpenNlpNer {

    private static final SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;

    private final NameFinderME nameFinderME;

    public OpenNlpNer() throws IOException {

        final InputStream inputStream = getClass().getResourceAsStream("/models/en-ner-person.bin");
        final TokenNameFinderModel model = new TokenNameFinderModel(inputStream);
        nameFinderME = new NameFinderME(model);
        inputStream.close();

    }

    public List<PhilterSpan> extract(String text) {

        final String[] tokens = tokenizer.tokenize(text);
        final Span[] spans = nameFinderME.find(tokens);

        final List<PhilterSpan> philterSpans = new LinkedList<>();

        for(Span span : spans) {

            System.out.println(span.toString());

            final String entity = span.getCoveredText(text).toString();

            final int start = text.indexOf(entity);
            final int end = text.indexOf(entity) + entity.length();

            philterSpans.add(new PhilterSpan(entity, span.getProb(), start, end, span.getType()));

        }

        return philterSpans;

    }

}
