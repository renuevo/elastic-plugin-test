package org.elastic.index;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class JamoTokenFilter extends TokenFilter {

    CharTermAttribute charTermAttribute = addAttribute(CharTermAttribute.class);
    Parser parser;

    protected JamoTokenFilter(TokenStream input, Parser parser) {
        super(input);
        this.parser = parser;
    }

    @Override
    public boolean incrementToken() throws IOException {

        if(input.incrementToken()){
            String result = parser.parser(charTermAttribute.toString());
            charTermAttribute.setEmpty().append(result);
            return true;
        }

        return false;
    }
}
