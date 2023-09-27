package net.dlta.schnitzelmod.block.custom;

import com.ibm.icu.util.LocaleMatcher;
import net.dlta.schnitzelmod.blockentity.PlateBlockEntity;
import net.dlta.schnitzelmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class PlateBlock extends Block implements EntityBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public PlateBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntities.PLATE_BLOCK_ENTITY.get().create(pos, state);
    }

    @Override
    protected  void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        BlockEntity be = level.getBlockEntity(pos);
        if(be instanceof  PlateBlockEntity blockEntity) {
            if (stack.getItem() == ModItems.FLOUR_WHEAT.get()) {
                if(blockEntity.addFlour()) {
                    stack.shrink(1);
                    return InteractionResult.SUCCESS;
                }
            } else if (stack.getItem() == ModItems.PORK_HAMMERED.get()) {
                if(blockEntity.removeFlour()){
                    stack.shrink(1);
                    player.addItem(new ItemStack(ModItems.PORK_FLOUR.get()));
                    // Return success
                    return InteractionResult.SUCCESS;
                }
            } else if (stack.getItem() == Items.EGG){
                if(blockEntity.addEgg()){
                    stack.shrink(1);
                    return InteractionResult.SUCCESS;
                }
            } else if (stack.getItem() == ModItems.PORK_FLOUR.get()){
                if(blockEntity.removeEgg()){
                    stack.shrink(1);
                    player.addItem(new ItemStack(ModItems.PORK_EGG.get()));
                    return InteractionResult.SUCCESS;
                }
            } else if (stack.getItem() == ModItems.SEMMELBROESEL.get()){
                if(blockEntity.addBroesel()){
                    stack.shrink(1);
                    return InteractionResult.SUCCESS;
                }
            } else if (stack.getItem() == ModItems.PORK_EGG.get()){
                if(blockEntity.removeBroesel()){
                    stack.shrink(1);
                    player.addItem(new ItemStack(ModItems.SCHNITZEL_RAW.get()));
                    return InteractionResult.SUCCESS;
                }
            }

        }
        return InteractionResult.PASS;
    }

        /*if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            BlockEntity be = level.getBlockEntity(pos);
            if(be instanceof PlateBlockEntity blockEntity) {
                int counter = 99;
                if(player.isCrouching()){
                    counter = blockEntity.getCounter();
                } else {
                    counter = blockEntity.incrementCounter();
                }
                player.sendSystemMessage(Component.literal("BlockEntity has been used %d times".formatted(counter)));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return super.use(state, level, pos, player, hand, hit);
    }*/

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }
}
