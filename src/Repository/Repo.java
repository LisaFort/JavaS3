package Repository;

import Domain.ProgState;
import com.company.*;

/**
 * Created by Melisa on 14/10/2015.
 */
public interface Repo {

   public void addState(ProgState stat);
   public ProgState getCtrlProg();
   public int size();
}
