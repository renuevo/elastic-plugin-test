package org.elastic.index;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class WhiteSpaceTokenFilter extends TokenFilter {

    private CharTermAttribute termAttr;

    public WhiteSpaceTokenFilter(TokenStream stream) {
        super(stream);
        this.termAttr = addAttribute(CharTermAttribute.class);  //현재 검색중인 토큰 정보에 접근가능
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            char[] originalTerm = termAttr.buffer();
            if(originalTerm.length > 0){
                StringBuilder stringBuilder = new StringBuilder(new String(originalTerm).trim()).reverse();
                termAttr.setEmpty();
                termAttr.append(stringBuilder.toString());
            }
            return true;
        }
        return false;
    }

}
