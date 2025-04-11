package com.liang.springcore;

public class Instrumentalist  implements Performer, Cloneable {
    private Instrument instrument;

    public Instrumentalist(Instrument instrument) {
        this.instrument = instrument;
    }

    public void perform() throws PerformanceException {
        instrument.play();
    }

    public Instrument getInstrument() {
        return instrument;
    }
}
