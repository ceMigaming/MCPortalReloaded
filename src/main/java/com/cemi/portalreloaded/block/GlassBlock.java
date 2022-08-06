package com.cemi.portalreloaded.block;

import java.util.Random;

import com.cemi.portalreloaded.client.PortalTabs;
import com.cemi.portalreloaded.entity.EntityHEP;
import com.cemi.portalreloaded.tileentity.TileEntityBallLauncher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GlassBlock extends PortalBlock {


    private final boolean ignoreSimilarity;

    public GlassBlock(String name)
    {
        super(Material.GLASS, name);
        this.ignoreSimilarity = true;
        setCreativeTab(PortalTabs.PORTAL_BUILDING_BLOCKS);
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();


        
        if (this == PortalBlocks.glassBlock || this == PortalBlocks.seemedGlassBlock)
        {
            if (block == PortalBlocks.glassBlock || block == PortalBlocks.seemedGlassBlock)
            {
                return false;
            }
        }

        return !this.ignoreSimilarity && block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
	
    public int quantityDropped(Random random)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

}
