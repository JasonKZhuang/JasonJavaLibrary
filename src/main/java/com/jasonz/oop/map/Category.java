package com.jasonz.oop.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    private int code; //PteConstants.CODE_SPEAKING
    private String category;//PteConstants.SPEAKING

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        // If the object is compared with itself then return true
        if (this == obj)
            return true;

         /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof Category)) {
            return false;
        }

        if (getClass() != obj.getClass())
            return false;

        Category student = (Category) obj;
        if (student.getCode() == code && student.getCategory() == category) {
            return true;
        } else {
            return false;
        }
    }
}
