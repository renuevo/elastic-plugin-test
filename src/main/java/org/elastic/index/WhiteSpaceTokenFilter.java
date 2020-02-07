package org.elastic.index;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class WhiteSpaceTokenFilter extends TokenFilter {

    private CharTermAttribute termAtt;

    public WhiteSpaceTokenFilter(TokenStream stream) {
        super(stream);
        this.termAtt = addAttribute(CharTermAttribute.class);
    }

    @Override
    public boolean incrementToken() throws IOException {

        if (input.incrementToken()) {
            termAtt.buffer();
            return true;
        }

        return false;
    }

}
