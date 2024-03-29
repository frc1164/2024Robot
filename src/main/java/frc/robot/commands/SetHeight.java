// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.LiftConstants;
import frc.robot.Constants.LiftConstants.Setpoint;
import frc.robot.subsystems.Lift;

public class SetHeight extends Command {
  private final Lift m_Lift;
  private Setpoint m_setpoint = Setpoint.STOW;
  /** Creates a new SetHeight. */
  public SetHeight(Lift lift, LiftConstants.Setpoint setpoint) {
      m_Lift = lift;
      m_setpoint = setpoint;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Lift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Lift.setLiftPID(m_setpoint);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Lift.runLiftSetpoint();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
