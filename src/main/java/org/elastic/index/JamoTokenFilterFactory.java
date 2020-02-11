package org.elastic.index;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class JamoTokenFilterFactory extends AbstractTokenFilterFactory {

    private final JamoParser jamoParser;

    public JamoTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings){
        super(indexSettings, name, settings);
        this.jamoParser = new JamoParser();
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new JamoTokenFilter(tokenStream, jamoParser);
    }
}