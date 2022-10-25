package algorithms.algorithm_221025;

import java.util.HashSet;
import java.util.Set;

public class HashTable {

    private int size = 10000;
    private int[] table = new int[size];


    public HashTable() {
    }

    private HashTable(int size) {
        this.size = size;
        this.table = new int[size];
    }

    //hash 구현
    public int hash(String  key) {
        int asciiSum = 0;
        for (int i = 0 ; i < key.length(); i++) {
            asciiSum += key.charAt(i);;
        }
        return asciiSum % size; //배열 size 내에 key를 할당하기 위해
    }

    //데이터 저장 method
    public void insert(String key, Integer value) {
        int hashCode = hash(key);
        this.table[hashCode] = value;
        System.out.println(hashCode + "방에 저장이 완료 되었습니다.");
    }

    //key값으로 value search
    public int search(String key) {
        return this.table[hash(key)];
    }


    public static void main(String[] args) {
        String[] names = new String[]{"DongyeonKang",
                "SubinKang", "KwanwunKo", "HyunseokKo", "KyoungdukKoo", "YeonjiGu", "SoyeonKown", "OhsukKwon", "GunwooKim", "KiheonKim", "NayeongKim", "DohyeonKim", "MinkyoungKim", "MinjiKim", "SanghoKim", "SolbaeKim", "YejinKim", "EungjunKim", "JaegeunKim", "JeonghyeonKim", "JunhoKim", "JisuKim", "kimjinah", "HaneulKim", "HeejungKim", "KimoonPark", "EunbinPark", "JeongHoonPark", "JeminPark", "TaegeunPark", "JiwonBae", "SeunggeunBaek", "JihwanByeon", "HeungseopByeon", "JeongHeeSeo", "TaegeonSeo", "SeeYunSeok", "SuyeonSeong", "SeyoelSon", "MinjiSong", "JinwooSong", "hyunboSim", "SominAhn", "JiyoungAhn", "ChangbumAn", "SoonminEom",
                "HyeongsangOh", "SuinWoo", "JuwanWoo", "InkyuYoon", "GahyunLee", "DaonLee", "DohyunLee", "SanghunLee", "SujinLee", "AjinLee", "YeonJae", "HyeonjuLee", "HakjunYim", "SeoyunJang", "SeohyeonJang", "JinseonJang", "SujinJeon", "SeunghwanJeon", "DaehwanJung", "JaeHyunJeung", "HeejunJeong", "GukhyeonCho", "MunjuJo", "YejiJo", "ChanminJu", "MinjunChoi", "SujeongChoi", "SeunghoChoi", "AyeongChoi", "GeonjooHan", "JinhyuckHeo", "MinwooHwang", "SieunHwang",
                "JunhaHwang"};
        HashTable ht = new HashTable(200); //Hash충돌이 나지 않으면서도 메모리를 너무많이 쓰지 않는 size

        for (int i = 0 ; i < names.length; i++) {
            ht.insert(names[i], ht.hash(names[i]));
        }

        System.out.println(ht.search("DongyeonKang"));
        System.out.println(ht.search("JiyoungAhn"));
    }
}
