package com.sanjay.car.rental.entity;
public enum CarFeature {
        AIR_CONDITIONING("Air Conditioning", true),
        SUNROOF("Sunroof", false),
        BLUETOOTH("Bluetooth", true),
        GPS("GPS", true),
        FM_RADIO("FM Radio", true),
        POWER_WINDOWS("Power Windows", false),
        DUAL_FRONT_AIRBAGS("Dual Front Airbags", false),
        PARKING_SENSORS("Parking Sensors", true),
        ABS_BRAKES("Abs Brakes", false),
        FABRIC_SEATS("Fabric Seats", true);

        private final String name;
        private final boolean isAvailable;

        CarFeature(String name, boolean isAvailable) {
            this.name = name;
            this.isAvailable = isAvailable;
        }

        public String getName() {
            return name;
        }

        public boolean isAvailable() {
            return isAvailable;
        }
}




