package org.example.utils;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;

import java.time.Instant;

public class ResultSender {

    private static InfluxDBClient _client = null;
    private static char[] token = "Jm0ywTO02PtuNqS5HyuJTmvad6b7vzpIoA2UQniBlSRLV5yLCkgIkaRRWTpw8waIoFfNAZt00ENbiAmfjWAdlQ==".toCharArray();

//    static{
//    }

    public static void send(final Point point){
        _client = InfluxDBClientFactory.create("https://us-west-2-1.aws.cloud2.influxdata.com", token);
        WriteApi writeApi = _client.getWriteApi();
        writeApi.writePoint("testngreportdata", "bitrockmedia@gmail.com", point);
        _client.close();
    }
}