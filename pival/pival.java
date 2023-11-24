package pival;
import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.conf.Configuration;
public class pival{
       public static void main(String[] args) throws Exception{
           Configuration conf=new Configuration();
           Job job=new Job(conf,"Word Count");
           job.setJarByClass(pival.class);
           job.setMapperClass(map.class);
           job.setReducerClass(reduce.class);
           
           job.setOutputKeyClass(Text.class);
           job.setOutputValueClass(Text.class);
           FileInputFormat.addInputPath(job,new Path(args[0]));
           FileOutputFormat.setOutputPath(job,new Path(args[1]));
           job.waitForCompletion(true);
       }

}
