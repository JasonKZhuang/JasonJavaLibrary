package behavioralPatterns.Visitor;

/**
 * this is the abstract element class
 * @author Jason.Zhuang
 * @studentId s3535252
 * May 3, 2018
 * Employee.java
 * Describe:
 */
public abstract class AbstractElementEmployee
{
	public abstract void accept(IAbstractVisitorDepartment handler);
}
