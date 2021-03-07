package me.murrobby.igsq.spigot.smp.aspect;

import me.murrobby.igsq.spigot.smp.Player_SMP;

public class None_Aspect extends Base_Aspect
{

	public None_Aspect(Player_SMP player) //Player Instance
	{
		generate(player);
	}
	public None_Aspect() //Internal constructor
	{
		generate();
	}
	@Override
	protected void generate() 
	{
		setID(Enum_Aspect.NONE);
	}
	@Override
	public void aspectTick() 
	{

	}
	@Override
	public void aspectSecond() 
	{
		
	}
}
