package homework.chegg.com.chegghomework.data.entities;

import java.util.List;

/**
 * Created by DanielR on 01/12/2017.
 */

public interface DataConverter<FROM,TO> {

   List<TO> convert(FROM source);

   void fetchData();

}
