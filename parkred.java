package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Autonomous park red corner", group="Linear Opmode")
//@Disabled
public class parkred extends LinearOpMode {

    // Declare OpMode members.
    HardwareMapRev robot = new HardwareMapRev();


    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        //runtime.reset();
        // drive(0,0, 0 );
        // while(runtime.milliseconds() >= 30000){
///
        // }


        robot.servoClawLeftTop.setPosition(0);
        robot.servoClawRightTop.setPosition(1);

        delaymilliseconds(1000);

        robot.motorArm.setPower(0.4);

        delaymilliseconds(500);

        robot.motorArm.setPower(0);

        delaymilliseconds(100);

        robot.FrontRight.setPower(.5);
        robot.FrontLeft.setPower(-.5);
        robot.BackRight.setPower(.5);
        robot.BackLeft.setPower(-.5);

        delaymilliseconds(900);

        robot.FrontRight.setPower(0);
        robot.FrontLeft.setPower(0);
        robot.BackRight.setPower(0);
        robot.BackLeft.setPower(0);

        delaymilliseconds(900);

        robot.FrontRight.setPower(.5);
        robot.FrontLeft.setPower(.5);
        robot.BackRight.setPower(-.5);
        robot.BackLeft.setPower(-.5);

        delaymilliseconds(400);

        robot.FrontRight.setPower(.5);
        robot.FrontLeft.setPower(-.5);
        robot.BackRight.setPower(.5);
        robot.BackLeft.setPower(-.5);

        delaymilliseconds(400);

        robot.FrontRight.setPower(0);
        robot.FrontLeft.setPower(0);
        robot.BackRight.setPower(0);
        robot.BackLeft.setPower(0);

        delaymilliseconds(400);

        robot.servoClawLeftTop.setPosition(1);
        robot.servoClawRightTop.setPosition(0);

        delaymilliseconds(1000);

        robot.FrontRight.setPower(-.5);
        robot.FrontLeft.setPower(.5);
        robot.BackRight.setPower(-.5);
        robot.BackLeft.setPower(.5);

        delaymilliseconds(150);

        robot.FrontRight.setPower(0);
        robot.FrontLeft.setPower(0);
        robot.BackRight.setPower(0);
        robot.BackLeft.setPower(0);

        delaymilliseconds(400);

        robot.servoClawLeftTop.setPosition(1);
        robot.servoClawRightTop.setPosition(0);

        delaymilliseconds(1000);

    }

    private void delaymilliseconds(double milliseconds)  {
        double stoptime = runtime.milliseconds() + milliseconds;

        while (opModeIsActive() && runtime.milliseconds() < stoptime);
    }

}