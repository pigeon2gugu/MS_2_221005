package class_221007.MiniProjectPopulation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PopulationStatics {

    public void readByChar(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        // 위의 단계 까지는 파일을 읽지 않는다. read()해야 읽기 시작함.

        char c1 = (char) fileReader.read(); //return type int형
        System.out.println(c1);
    }

    public List<PopulationMove> readByLine(String filename) throws IOException {
        List<PopulationMove> pml = new ArrayList<>();
        BufferedReader br = new BufferedReader(
                new FileReader(filename)
        );
        String str;
        while ((str = br.readLine()) != null) {
            //System.out.println(str);
            PopulationMove pm = parse(str);
            pml.add(pm);
        }
        br.close();

        return pml;
    }

    public String readByLine2(String filename) {
        String data = "";
        try (BufferedReader br = Files.newBufferedReader(
                Paths.get(filename), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                data += line;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    /* 전체 파일 파싱
    public PopulationMove parse(String data) {

        String[] splitedLine = data.split(",");
        return new PopulationMove(splitedLine[0],splitedLine[6]);

    }
     */

    public PopulationMove parse(String data) {

        String[] splitedLine = data.split(",");
        return new PopulationMove(splitedLine[0], splitedLine[1]);

    }

    public void createAFile(String filename) {
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // List<String>을 지정한 파일에 write
    public void write(List<String> strs, String filename) {
        File file = new File(filename);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String str : strs) {
                writer.write(str);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String fromToString(PopulationMove populationMove) {
        return populationMove.getFromSido() + "," + populationMove.getToSido() + "\n";

    }

    public Map<String, Integer> getMoveCnt(List<PopulationMove> pml) {

        Map<String, Integer> moveCntMap = new HashMap<>();
        for(PopulationMove pm : pml) {
            String key = pm.getFromSido()+","+ pm.getToSido();
            if(moveCntMap.get(key) == null) {
                moveCntMap.put(key, 1);
            } else {
                moveCntMap.put(key, moveCntMap.get(key) + 1);
            }
        }

        return moveCntMap;
    }

    public Map<String, Integer> heatmapIdxMap() {
        Map<String, Integer> map = new HashMap<>();

        map.put("11",0);
        map.put("26",1);
        map.put("27",2);
        map.put("28",3);
        map.put("29",4);
        map.put("30",5);
        map.put("31",6);
        map.put("36",7);
        map.put("41",8);
        map.put("42",9);
        map.put("43",10);
        map.put("44",11);
        map.put("45",12);
        map.put("46",13);
        map.put("47",14);
        map.put("48",15);
        map.put("50",16);

        return map;
    }

    public static void main(String[] args) throws IOException {

        String address2 = "./from_to.txt"; //from to만 뺀 txt
        PopulationStatics populationStatics = new PopulationStatics();
        List<PopulationMove> pml = populationStatics.readByLine(address2);

        Map<String, Integer> map = populationStatics.getMoveCnt(pml);
        Map<String, Integer> heatMapIdxMap = populationStatics.heatmapIdxMap();

        List<String> cntResult = new ArrayList<>();

        for(String key : map.keySet()) {
            String[] fromto = key.split(",");
            //매핑을 해서 저장
            String s = String.format("[%s, %s, %d]\n", heatMapIdxMap.get(fromto[0]), heatMapIdxMap.get(fromto[1]), map.get(key));
            //String s = String.format("[%s, %s, %d]\n",fromto[0], fromto[1], map.get(key));
            cntResult.add(s);
            //System.out.printf("key : %s value : %d\n",key, map.get(key));
        }

        populationStatics.createAFile("./for_heatmap_idx.txt");
        populationStatics.write(cntResult,"./for_heatmap_idx.txt");



        //System.out.println(map);


        /*
        Set<Integer> sidoCodes = new HashSet<>();

        for (PopulationMove pm : pml) {
            System.out.printf("전입 : %s, 전출 : %s\n", pm.getFromSido(), pm.getToSido());
            //sidoCodes.add(pm.getFromSido());
            //sidoCodes.add(pm.getToSido());
        }
        //System.out.println(sidoCodes);
         */
        /*
        String address = "C:\\Users\\khn11\\Downloads\\2021_인구관련연간자료_20220927_66125.csv";
        PopulationStatics populationStatics = new PopulationStatics();

        List<PopulationMove> pml = populationStatics.readByLine(address);

        List<String> strings = new ArrayList<>();

        for(PopulationMove pm : pml) {
            //System.out.printf("전입 : %s, 전출 : %s\n",pm.getFromSido(), pm.getToSido());
            String fromTo = populationStatics.fromToString(pm);
            strings.add(fromTo);
        }


        populationStatics.createAFile("./from_to.txt");
        populationStatics.write(strings, "./from_to.txt");
         */
    }
}



