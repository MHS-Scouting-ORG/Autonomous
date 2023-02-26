package frc.robot.commands.ElevatorCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PivotSubsystem;

public class PivotLowCmd extends CommandBase{
    private PivotSubsystem p_subs;

    public PivotLowCmd(PivotSubsystem subs){
        p_subs = subs;
        addRequirements(subs);
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        SmartDashboard.putNumber("Pivot Encoder: ", p_subs.getEncoder());
        p_subs.newSetpoint(63);
    }

    @Override
    public boolean isFinished(){
        return p_subs.isAtSetPoint();
    }

}