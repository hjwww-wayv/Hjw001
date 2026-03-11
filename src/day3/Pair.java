package day3;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pair<ke,va> {
    private ke key;
    private va value;


}
