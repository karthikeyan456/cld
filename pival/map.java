package pival;
import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class map extends Mapper<LongWritable,Text,Text,Text>{
        public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException{
        int j=100;
        Random rand=new Random();
        for(int k=0;k<100;k++){
            double x=rand.nextDouble();
            double y=rand.nextDouble();
            if(x*x+y*y<1){
               context.write(new Text(Integer.toString(0)),new Text(Integer.toString(1)));
            }
            else{
               context.write(new Text(Integer.toString(0)),new Text(Integer.toString(0)));
            }
        }

}
}
