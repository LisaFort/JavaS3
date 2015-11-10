package Repository;

import Domain.ProgState;
import com.company.*;

/**
 * Created by Melisa on 14/10/2015.
 */
public class Repository implements Repo {
    private ProgState[] status;
    final int MAX = 10;
    int nrEl;

    /**
     * Constructor
     * status - array of prog state
     */
    public Repository() {
        status = new ProgState[MAX];
        nrEl = 0;
    }

    /**
     * Adds a Program state to the repository
     * @param stat
     */
    public void addState(ProgState stat) {
        status[nrEl++] = stat;
    }

    /**
     * Returns a program state from the repository list
     * @return
     */
    public ProgState getCtrlProg() {
        if (nrEl == 0) {
            return null;
        } else {
            ProgState prg = new ProgState(new ArrayStack(), new ArrayDictionary(), new ArrayList());
            nrEl = nrEl - 1;
            prg = status[nrEl];
            return prg;
        }
    }

    /**
     * Returns the number of elements from the program state
     * @return
     */
    public int size() {
        return nrEl;
    }
}
