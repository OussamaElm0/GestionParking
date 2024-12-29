package vehicules;

import exceptions.MatriculAlreadyExist;

public interface Parkable {
    void park() throws MatriculAlreadyExist;
}
