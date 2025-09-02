package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
@TeleOp
public class RobotCentric extends LinearOpMode{
    public  void runOpMode(){


        DcMotor TopLeftMotor = hardwareMap.get(DcMotor.class, "TopLeft Motor");//1
        DcMotor TopRightMotor = hardwareMap.get(DcMotor.class, "TopRight Motor");//3
        DcMotor BottomLeftMotor = hardwareMap.get(DcMotor.class, "BottomLeft Motor");//2
        DcMotor BottomRightMotor = hardwareMap.get(DcMotor.class, "BottomRight Motor"); //0
        TopLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        TopRightMotor.setDirection(DcMotor.Direction.FORWARD );
        BottomLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        BottomRightMotor.setDirection(DcMotor.Direction.FORWARD);
        waitForStart();
        while(opModeIsActive()){
            Gamepad currentGamepad1 = new Gamepad();
            double vertical = -gamepad1.left_stick_y;
            double horizontal = gamepad1.left_stick_x;
            double rotation = gamepad1.right_stick_x;
            TopLeftMotor.setPower(vertical + horizontal + rotation);
            BottomLeftMotor.setPower(vertical - horizontal + rotation);
            TopRightMotor.setPower(vertical - horizontal - rotation);
            BottomRightMotor.setPower(vertical + horizontal - rotation);
           }
        }
    }
