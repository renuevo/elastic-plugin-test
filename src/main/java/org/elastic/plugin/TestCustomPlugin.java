package org.elastic.plugin;

import org.elastic.index.WhiteSpaceTokenFilterFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.HashMap;
import java.util.Map;

public class TestCustomPlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {

        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> tokenizerFactories = new HashMap<>();
        tokenizerFactories.put("testElasticPlugin", WhiteSpaceTokenFilterFactory::new);
        return tokenizerFactories;
    }

}
