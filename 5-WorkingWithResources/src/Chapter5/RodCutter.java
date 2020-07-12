package Chapter5;

import java.util.List;

public class RodCutter {

    private boolean mustFail;

    public RodCutter(final boolean fail) {
        this.mustFail = fail;
    }

    public void setPrices(final List<Integer> prices){
        //....
        if(mustFail)
            throw new RodCutterException();
    }

    public int maxProfit(final int length){
        if(length == 0)
            throw new RodCutterException();

        return 0;
    }
}
