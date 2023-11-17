package com.jasonz.dataStructures.collection.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    String name;
    int age;
    float marks;

    // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        // If the object is compared with itself then return true
        if (this == obj)
            return true;

         /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof Student)) {
            return false;
        }

        if (getClass() != obj.getClass())
            return false;

        Student student = (Student) obj;
        if (student.getName().equals(name)
                && student.getMarks() == marks
                && student.getAge() == age) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }
}
