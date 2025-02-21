package vehicules;

import exceptions.MatriculAlreadyExistException;

public interface Parkable {
    void park() throws MatriculAlreadyExistException;
}
