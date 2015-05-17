package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Sequence;

/**
 * Created by jinyejun on 5/13/15.
 */
public interface SequenceDAO {

    Sequence getSequence(Sequence sequence);
    void updateSequence(Sequence sequence);
}
