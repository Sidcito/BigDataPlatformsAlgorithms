package it.uniroma1.hadoop.pagerank.job2;

import it.uniroma1.hadoop.pagerank.PageRank;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PageRankJob2Reducer extends Reducer<Text, Text, Text, Text> {
    
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, 
                                                                                InterruptedException {

        
        String links = "";
        double sumShareOtherPageRanks = 0.0;
        
        for (Text value : values) {
 
            String content = value.toString();
            
            if (content.startsWith(PageRank.LINKS_SEPARATOR)) {
                // if this value contains node links, we append them to the 'links' string
                // for future use: this is needed to reconstruct the input for Job 2 mapper
                // in case of multiple iterations on the very same.
                links += content.substring(PageRank.LINKS_SEPARATOR.length());
            } else {
                
                String[] split = content.split("\\t");
                
                // Here we are extracting tokens
                double pageRank = Double.parseDouble(split[0]);
                int totalLinks = Integer.parseInt(split[1]);
                
                // Now we add the contribution of all the pages having an outlink pointing 
                // to the current node: we will add the DAMPING factor later when recomputing
                // the final pagerank value before submitting the result to the next job.
                sumShareOtherPageRanks += (pageRank / totalLinks);
            }

        }
        
        double newRank = PageRank.DAMPING * sumShareOtherPageRanks + (1 - PageRank.DAMPING);
        context.write(key, new Text(newRank + "\t" + links));
        
    }

}