package com.cemi.portalreloaded.block;

import java.util.List;

import com.cemi.portalreloaded.entity.EntityCubeBase;
import com.cemi.portalreloaded.entity.EntityPivotCube;
import com.cemi.portalreloaded.entity.EntityStorageCube;

import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFloorButton extends BlockFloorButtonBase {

	public static final PropertyBool POWERED = PropertyBool.create("powered");
    private final BlockFloorButton.Sensitivity sensitivity;
    private final BlockFloorButton.Style style;
	
	public BlockFloorButton(String name, Sensitivity sensitivity, Style style) {
		super(Material.IRON, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(POWERED, Boolean.valueOf(false)));
		this.sensitivity = sensitivity;
		this.style = style;
	}

	@Override
	protected void playClickOnSound(World worldIn, BlockPos color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void playClickOffSound(World worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int computeRedstoneStrength(World worldIn, BlockPos pos)
    {
        AxisAlignedBB axisalignedbb = PRESSURE_AABB.offset(pos);
        List <? extends Entity > list;

        switch (this.sensitivity)
        {
            case EVERYTHING:
                list = worldIn.getEntitiesWithinAABBExcludingEntity((Entity)null, axisalignedbb);
                break;
            case CUBES:
                list = worldIn.<Entity>getEntitiesWithinAABB(EntityCubeBase.class, axisalignedbb);
                break;
            case SPHERES:
            default:
                return 0;
        }

        if (!list.isEmpty())
        {
            for (Entity entity : list)
            {
                if (!entity.doesEntityNotTriggerPressurePlate())
                {
                    return 15;
                }
            }
        }

        return 0;
    }

	@Override
	protected int getRedstoneStrength(IBlockState state)
    {
		return ((Boolean)state.getValue(POWERED)).booleanValue() ? 15 : 0;
    }

	@Override
	protected IBlockState setRedstoneStrength(IBlockState state, int strength) {
		return state.withProperty(POWERED, Boolean.valueOf(strength > 0));
	}
	
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(POWERED, Boolean.valueOf(meta == 1));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Boolean)state.getValue(POWERED)).booleanValue() ? 1 : 0;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {POWERED});
    }
    
	public static enum Sensitivity
    {
        EVERYTHING,
        CUBES,
        SPHERES;
    }
	
	public static enum Style
	{
		NEW,
		OLD,
		DAMAGED;
	}
}
