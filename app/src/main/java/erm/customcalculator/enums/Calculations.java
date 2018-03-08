package erm.customcalculator.enums;

import android.content.Context;

import erm.customcalculator.R;
import erm.customcalculator.classes.Utils;
import erm.customcalculator.fragments.AngleConversionFragment;
import erm.customcalculator.fragments.ArcSinCosTangFragment;
import erm.customcalculator.fragments.ArithmeticFragment;
import erm.customcalculator.fragments.BinProbFragment;
import erm.customcalculator.fragments.CalcBase;
import erm.customcalculator.fragments.CombinationFragment;
import erm.customcalculator.fragments.ConfidenceIntervalFragment;
import erm.customcalculator.fragments.DistanceBetweenObjectsFragment;
import erm.customcalculator.fragments.GeoProbFragment;
import erm.customcalculator.fragments.GravitationalForceFragment;
import erm.customcalculator.fragments.MassOfObjectFragment;
import erm.customcalculator.fragments.NetForceFragment;
import erm.customcalculator.fragments.OneSampleZScoreFragment;
import erm.customcalculator.fragments.PermutationFragment;
import erm.customcalculator.fragments.QuadraticFormulaFragment;
import erm.customcalculator.fragments.SineCosineTangentFragment;
import erm.customcalculator.fragments.StdDeviationOfSamplingDistributionFragment;
import erm.customcalculator.fragments.TwoSampleZScoreFragment;
import erm.customcalculator.fragments.ZScoreFragment;
import erm.customcalculator.fragments.ChiSquareFragment;
import erm.customcalculator.fragments.ConeFragment;
import erm.customcalculator.fragments.CylinderFragment;
import erm.customcalculator.fragments.OneSampleTScoreFragment;
import erm.customcalculator.fragments.TScoreFragment;
import erm.customcalculator.fragments.TwoSampleTScoreFragment;
import erm.customcalculator.fragments.PopulationStandardDeviationFragment;
import erm.customcalculator.fragments.SphereFragment;
import erm.customcalculator.fragments.StatisticsFragment;
import erm.customcalculator.fragments.StdErrorFragment;
import erm.customcalculator.fragments.TcdfFragment;
import erm.customcalculator.fragments.TwoSampleZIntervalFragment;
import erm.customcalculator.fragments.SpreadOfTwoProportionsFragment;
/**
 * Created by Logan on 1/31/2016.
 */
public enum Calculations {
    ARITHMETIC,COMBINATION,PERMUTATION,BINOMIAL_PROBABILITY,GEOMETRIC_PROBABILITY, STD_DEV_SPL_DISTRO,Z_SCORE,CONFIDENCE_INT,
    SINE_COSINE_TANGENT,ARC_SINE_COSINE_TANGENT,DEGREES_RADIANS,NET_FORCE,GRAV_FORCE,MASS,DIST_BET_OBJ,QUAD_FORMULA,
    CHI_SQUARE, CONE, SPHERE, CYLINDER, ONESAMPLE_TSCORE, TWOSAMPLE_TSCORE, ONESAMPLE_ZSCORE, TWOSAMPLE_ZSCORE, TWOSAMPLE_ZINTERVAL,
    POPULATION_STD_DEV, STD_ERROR, TCDF, STATISTICS, T_SCORE, SPREAD_TWO_PROPORTIONS;



    public static Calculations getCalculationByTitle(Context context, String title){
           Calculations eCalc = ARITHMETIC; //default if none found

           //must be a valid string
           if(!Utils.isValidString(title))
               return null;

           if(title.contains(context.getString(R.string.arithmetic))) {
               eCalc = ARITHMETIC;
           } else if(title.contains(context.getString(R.string.combination))){
               eCalc = COMBINATION;
           } else if(title.contains(context.getString(R.string.permutation))){
               eCalc = PERMUTATION;
           } else if(title.contains(context.getString(R.string.binomial_probability))){
               eCalc = BINOMIAL_PROBABILITY;
           } else if(title.contains(context.getString(R.string.geometric_probability))){
               eCalc = GEOMETRIC_PROBABILITY;
           }else if(title.contains(context.getString(R.string.std_deviation))){
               eCalc = STD_DEV_SPL_DISTRO;
           }else if(title.contains(context.getString(R.string.z_score))){
               eCalc = Z_SCORE;
           }else if(title.contains(context.getString(R.string.confidence_interval))) {
               eCalc = CONFIDENCE_INT;
           } else if(title.contains(context.getString(R.string.sine_cosine_tangent))){
                eCalc = SINE_COSINE_TANGENT;
           }else if(title.contains(context.getString(R.string.arc_sine_cosine_tangent))){
               eCalc = ARC_SINE_COSINE_TANGENT;
           }else if(title.contains(context.getString(R.string.degrees_radians))){
               eCalc = DEGREES_RADIANS;
           }else if(title.contains(context.getString(R.string.net_force))){
               eCalc = NET_FORCE;
           }else if(title.contains(context.getString(R.string.gravitation_force))){
               eCalc = GRAV_FORCE;
           }else if(title.contains(context.getString(R.string.mass_of_object))){
               eCalc = MASS;
           }else if(title.contains(context.getString(R.string.distance_between_objects))){
               eCalc = DIST_BET_OBJ;
           }else if(title.contains(context.getString(R.string.statistics))){
               eCalc = STATISTICS;
           }else if(title.contains(context.getString(R.string.population_std_deviation))){
               eCalc = POPULATION_STD_DEV;
           }else if(title.contains(context.getString(R.string.std_error))){
               eCalc = STD_ERROR;
           }else if(title.contains(context.getString(R.string.one_sample_zscore))){
               eCalc = ONESAMPLE_ZSCORE;
           }else if(title.contains(context.getString(R.string.two_sample_zscore))){
               eCalc = TWOSAMPLE_ZSCORE;
           }else if(title.contains(context.getString(R.string.two_sample_zinterval))){
               eCalc = TWOSAMPLE_ZINTERVAL;
           }else if(title.contains(context.getString(R.string.t_score))){
               eCalc = T_SCORE;
           }else if(title.contains(context.getString(R.string.one_sample_tscore))){
               eCalc = ONESAMPLE_TSCORE;
           }else if(title.contains(context.getString(R.string.two_sample_tscore))){
               eCalc = TWOSAMPLE_TSCORE;
           }else if(title.contains(context.getString(R.string.chisquare))){
               eCalc = CHI_SQUARE;
           }else if(title.contains(context.getString(R.string.spread_of_two_proportions))){
               eCalc = SPREAD_TWO_PROPORTIONS;
           }else if(title.contains(context.getString(R.string.tcdf))){
               eCalc = TCDF;
           }else if(title.contains(context.getString(R.string.quadratic_formula))){
               eCalc = QUAD_FORMULA;
           }else if(title.contains(context.getString(R.string.cone))){
               eCalc = CONE;
           }else if(title.contains(context.getString(R.string.cylinder))){
               eCalc = CYLINDER;
           }else if(title.contains(context.getString(R.string.sphere))){
               eCalc = SPHERE;
           }

        return eCalc;
    }

    public static CalcBase getFragmentByCalculation(Calculations eCalc){
        CalcBase frag= new ArithmeticFragment(); //default if none found

        if(eCalc==ARITHMETIC) {
            frag = new ArithmeticFragment();
        } else if(eCalc == COMBINATION){
            frag = new CombinationFragment();
        } else if(eCalc == PERMUTATION){
            frag = new PermutationFragment();
        }else if(eCalc == BINOMIAL_PROBABILITY){
            frag = new BinProbFragment();
        }else if(eCalc == GEOMETRIC_PROBABILITY){
            frag = new GeoProbFragment();
        }else if(eCalc == STD_DEV_SPL_DISTRO){
            frag = new StdDeviationOfSamplingDistributionFragment();
        }else if(eCalc == Z_SCORE){
            frag = new ZScoreFragment();
        }else if(eCalc == CONFIDENCE_INT){
            frag = new ConfidenceIntervalFragment();
        }else if(eCalc == SINE_COSINE_TANGENT){
            frag = new SineCosineTangentFragment();
        }else if(eCalc == ARC_SINE_COSINE_TANGENT){
            frag = new ArcSinCosTangFragment();
        }else if(eCalc == DEGREES_RADIANS){
            frag = new AngleConversionFragment();
        }else if(eCalc == NET_FORCE){
            frag = new NetForceFragment();
        }else if(eCalc == GRAV_FORCE){
            frag = new GravitationalForceFragment();
        }else if(eCalc == MASS){
            frag = new MassOfObjectFragment();
        }else if(eCalc == DIST_BET_OBJ){
            frag = new DistanceBetweenObjectsFragment();
        }else if(eCalc == QUAD_FORMULA){
            frag = new QuadraticFormulaFragment();
        }else if(eCalc ==  TCDF){
            frag = new TcdfFragment();
        }else if(eCalc == STATISTICS){
            frag = new StatisticsFragment(); //Below this needs to be implemented
        }else if(eCalc == POPULATION_STD_DEV){
            frag = new PopulationStandardDeviationFragment();
        }else if(eCalc == STD_ERROR){
            frag = new StdErrorFragment();
        }else if(eCalc == ONESAMPLE_ZSCORE){
            frag = new OneSampleZScoreFragment();
        }else if(eCalc == TWOSAMPLE_ZSCORE){
            frag = new TwoSampleZScoreFragment();
        }else if(eCalc == TWOSAMPLE_ZINTERVAL){
            frag = new TwoSampleZIntervalFragment();
        }else if(eCalc == T_SCORE){
            frag = new TScoreFragment();
        }else if(eCalc == ONESAMPLE_TSCORE){
            frag = new OneSampleTScoreFragment();
        }else if(eCalc == TWOSAMPLE_TSCORE){
            frag = new TwoSampleTScoreFragment();
        }else if(eCalc == CHI_SQUARE){
            frag = new ChiSquareFragment();
        }else if(eCalc == SPREAD_TWO_PROPORTIONS){
            frag = new SpreadOfTwoProportionsFragment();
        }else if(eCalc == CONE){
            frag = new ConeFragment();
        }else if(eCalc == SPHERE){
            frag = new SphereFragment();
        }else if(eCalc == CYLINDER){
            frag = new CylinderFragment();
        }

        return frag;
    }

}
