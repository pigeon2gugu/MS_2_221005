package class_221012.BabyLion;




public class ClassEx {

        private String id;
        private String address;

        private String category;
        private Integer emergencyRoom;
        private String name;
        private String subdivision;

        public ClassEx(String id, String address, String category, Integer emergencyRoom, String name, String subdivision) {
            this.id = id;
            this.address = address;
            this.category = category;
            this.emergencyRoom = emergencyRoom;
            this.name = name;
            this.subdivision = subdivision;
        }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCategory() {
        return category;
    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public static void main(String[] args) {
        ClassEx hospitalEx = new ClassEx(
                "A1120837",
                "서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)",
                "C",
                2,
                "365병원",
                null
        );


        System.out.println(hospitalEx.getId());

    }
}
