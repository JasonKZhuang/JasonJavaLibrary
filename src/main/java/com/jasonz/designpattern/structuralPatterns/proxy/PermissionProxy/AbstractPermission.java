package com.jasonz.designpattern.structuralPatterns.proxy.PermissionProxy;

public interface AbstractPermission
{
	public void modifyUserInfo();

	public void viewNote();

	public void publishNote();

	public void modifyNote();

	public void setLevel(int level);
}