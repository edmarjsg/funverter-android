package com.funverter.converter;

/**
 * Created by Edmar on 7/14/2015.
 */
public enum VolumeUnit {
    CUBICMETER {
        public double toCubicMeter(double i) { return i; }
        public double toCubicInch(double i) { return i * 61023.7; }
        public double toCubicYard(double i) { return i * 1.30795062; }
        public double toLiter(double i) { return i * 1000; }
        public double toGallon(double i) { return i * 264.172; }
        public double toUsFluidOunce(double i) { return i * 33814; }
        public double toCubicFoot(double i) { return i * 35.3147; }
        public double toUsPint(double i) { return i * 2113.38; }
    },
    CUBICINCH {
        public double toCubicMeter(double i) { return i * 1.63871 * Math.pow(10, -5); }
        public double toCubicInch(double i) { return i; }
        public double toCubicYard(double i) { return i * 2.14334705 * Math.pow(10, -5); }
        public double toLiter(double i) { return i * 0.0163871; }
        public double toGallon(double i) { return i * 0.004329; }
        public double toUsFluidOunce(double i) { return i * 0.554113; }
        public double toCubicFoot(double i) { return i * 0.000578704; }
        public double toUsPint(double i) { return i * 0.034632; }
    },
    CUBICYARD {
        public double toCubicInch(double i) { return i * 46656; }
        public double toCubicMeter(double i) { return i * 0.764554858; }
        public double toCubicYard(double i) { return i; }
        public double toLiter(double i) { return i * 764.554858; }
        public double toGallon(double i) { return i * 201.974026; }
        public double toUsFluidOunce(double i) { return i * 25852.6753; }
        public double toCubicFoot(double i) { return i * 27; }
        public double toUsPint(double i) { return i * 1615.79221; }
    },
    LITER {
        public double toCubicInch(double i) { return i * 61.0237; }
        public double toCubicYard(double i) { return i * 0.00130795062; }
        public double toCubicMeter(double i) { return i * 0.001; }
        public double toLiter(double i) { return i; }
        public double toGallon(double i) { return i * 0.264172; }
        public double toUsFluidOunce(double i) { return i * 33.814; }
        public double toCubicFoot(double i) { return i * 0.0353147; }
        public double toUsPint(double i) { return i * 2.11338; }
    },
    GALLON {
        public double toCubicInch(double i) { return i * 231; }
        public double toCubicYard(double i) { return i * 0.00495113169; }
        public double toLiter(double i) { return i * 3.78541; }
        public double toGallon(double i) { return i; }
        public double toCubicMeter(double i) { return i * 0.00378541; }
        public double toUsFluidOunce(double i) { return i * 128; }
        public double toCubicFoot(double i) { return i * 0.133681; }
        public double toUsPint(double i) { return i * 8; }
    },
    USFLUIDOUNCE {
        public double toCubicInch(double i) { return i * 1.80469; }
        public double toCubicYard(double i) { return i * 3.86807163 * Math.pow(10, -5); }
        public double toLiter(double i) { return i * 0.0295735; }
        public double toGallon(double i) { return i * 0.0078125; }
        public double toUsFluidOunce(double i) { return i; }
        public double toCubicMeter(double i) { return i * 2.95735 * Math.pow(10, -5); }
        public double toCubicFoot(double i) { return i * 0.00104438; }
        public double toUsPint(double i) { return i * 0.0625; }
    },
    CUBICFOOT {
        public double toCubicInch(double i) { return i * 1728; }
        public double toCubicYard(double i) { return i * 0.037037037; }
        public double toLiter(double i) { return i * 28.3168; }
        public double toGallon(double i) { return i * 7.48052; }
        public double toUsFluidOunce(double i) { return i * 957.506; }
        public double toCubicFoot(double i) { return i; }
        public double toCubicMeter(double i) { return i * 0.0283168; }
        public double toUsPint(double i) { return i * 59.8442; }
    },
    USPINT {
        public double toCubicInch(double i) { return i * 28.875; }
        public double toCubicYard(double i) { return i * 0.000618891461; }
        public double toLiter(double i) { return i * 0.473176; }
        public double toGallon(double i) { return i * 0.125; }
        public double toUsFluidOunce(double i) { return i * 16; }
        public double toCubicFoot(double i) { return i * 0.0167101; }
        public double toCubicMeter(double i) { return i * 0.000473176; }
        public double toUsPint(double i) { return i; }
    };

    public double toCubicMeter(double i) { throw new AbstractMethodError(); }
    public double toCubicInch(double i) { throw new AbstractMethodError(); }
    public double toCubicYard(double i) { throw new AbstractMethodError(); }
    public double toLiter(double i) { throw new AbstractMethodError(); }
    public double toGallon(double i) { throw new AbstractMethodError(); }
    public double toUsFluidOunce(double i) { throw new AbstractMethodError(); }
    public double toCubicFoot(double i) { throw new AbstractMethodError(); }
    public double toUsPint(double i) { throw new AbstractMethodError(); }
}