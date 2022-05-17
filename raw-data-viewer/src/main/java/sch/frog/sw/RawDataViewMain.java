package sch.frog.sw;

import com.google.protobuf.util.JsonFormat;
import org.apache.skywalking.apm.network.language.agent.v3.SegmentObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

public class RawDataViewMain {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("trace.data"));
        String line;
        StringBuilder sb = new StringBuilder();
        while((line = reader.readLine()) != null){
            sb.append(line);
        }
        byte[] bytes = Base64.getDecoder().decode(sb.toString());
        SegmentObject segmentObject = SegmentObject.parseFrom(bytes);
        System.out.println(JsonFormat.printer().print(segmentObject));
    }

}
