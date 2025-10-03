package anotacao;

import java.lang.annotation.*;

/**
@author renan.eliziario
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}
