package net.dlta.schnitzelmod.blockentity;

import net.dlta.schnitzelmod.SchnitzelMod;
import net.dlta.schnitzelmod.block.custom.BlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PlateBlockEntity extends BlockEntity {

    private int counter;

    private int broeselAmount;
    private int eggAmount;
    private int flourAmount;
    public PlateBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.PLATE_BLOCK_ENTITY.get(), pos, state);
        flourAmount = 0;
        eggAmount = 0;
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        CompoundTag schnitzelmodData = nbt.getCompound(SchnitzelMod.MOD_ID);
        this.counter = schnitzelmodData.getInt("Counter");
        this.flourAmount = schnitzelmodData.getInt("flourAmount");
        this.eggAmount = schnitzelmodData.getInt("eggAmount");
        this.broeselAmount = schnitzelmodData.getInt("broeselAmount");
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        var schnitzelmodData = new CompoundTag();
        schnitzelmodData.putInt("Counter", this.counter);
        schnitzelmodData.putInt("flourAmount", this.flourAmount);
        schnitzelmodData.putInt("eggAmount", this.eggAmount);
        schnitzelmodData.putInt("broeselAmount", this.broeselAmount);
        nbt.put(SchnitzelMod.MOD_ID, schnitzelmodData);
    }

    public boolean addFlour(){
        if (flourAmount < 10 && eggAmount <= 0 && broeselAmount <= 0){
            ++this.flourAmount;
            setChanged();
            return true;
        }
        return false;
    }

    public boolean removeFlour(){
        if (flourAmount > 0 && eggAmount <= 0 && broeselAmount <= 0){
            --this.flourAmount;
            setChanged();
            return true;
        }
        return false;
    }

    public boolean addEgg(){
        if (eggAmount < 10 && flourAmount <= 0 && broeselAmount <= 0){
            ++this.eggAmount;
            setChanged();
            return true;
        }
        return false;
    }
    public boolean removeEgg(){
        if (eggAmount > 0 && flourAmount <= 0 && broeselAmount <= 0){
            --this.eggAmount;
            setChanged();
            return true;
        }
        return false;
    }

    public boolean addBroesel(){
        if (broeselAmount < 10 && flourAmount <= 0 && eggAmount <= 0){
            ++this.broeselAmount;
            setChanged();
            return true;
        }
        return false;
    }

    public boolean removeBroesel(){
        if (broeselAmount > 0 && flourAmount <= 0 && eggAmount <= 0){
            --this.broeselAmount;
            setChanged();
            return true;
        }
        return false;
    }

    public int incrementCounter(){
        ++this.counter;
        setChanged();
        return this.counter;
    }

    public int getCounter(){
        return this.counter;
    }
}
