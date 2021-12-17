package lk.example.test.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 12/17/21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {
    private String code;
    private String message;
    private Object data;
}
