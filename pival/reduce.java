package pival;
import java.util.*;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class reduce extends Reducer<Text,Text,Text,Text>{
     public void reduce(Text key,Iterable<Text> values, Context context) throws IOException, InterruptedException{
         int tot=0;
         int valid=0;
         for(Text t:values){
               String ts=t.toString();
               int tsint=Integer.parseInt(ts);
               if(tsint==1){
                 valid+=1;
               }
               tot+=1;
               
         }
         float piv=((float)valid/(float)tot)*4;
         context .write(new Text("Pi "),new Text(Float.toString(piv)));
     }

}
