package Processors;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;

import androidx.core.content.res.ResourcesCompat;

import com.facetec.sampleapp.R;
import com.facetec.sampleapp.SampleAppUtilities;
import com.facetec.sdk.FaceTecCancelButtonCustomization;
import com.facetec.sdk.FaceTecCustomization;
import com.facetec.sdk.FaceTecSDK;

import java.util.HashMap;
import java.util.Map;

public class ThemeHelpers {

    public static void setAppTheme(Context context, String theme) {
        Config.currentCustomization = getCustomizationForTheme(context, theme);
        FaceTecCustomization currentLowLightCustomization = getLowLightCustomizationForTheme(context, theme);
        FaceTecCustomization currentDynamicDimmingCustomization = getDynamicDimmingCustomizationForTheme(context, theme);

        SampleAppUtilities.setVocalGuidanceSoundFiles();
        FaceTecSDK.setCustomization(Config.currentCustomization);
        FaceTecSDK.setLowLightCustomization(currentLowLightCustomization);
        FaceTecSDK.setDynamicDimmingCustomization(currentDynamicDimmingCustomization);
    }

    public static FaceTecCustomization getCustomizationForTheme(Context context, String theme) {
        FaceTecCustomization currentCustomization = new FaceTecCustomization();

        int[] retryScreenSlideshowImages = new int[]{R.drawable.ideal_image_1, R.drawable.ideal_image_2, R.drawable.ideal_image_3, R.drawable.ideal_image_4, R.drawable.ideal_image_5};

        if(theme.equals("FaceTec Theme")) {
            currentCustomization = new FaceTecCustomization();
        }
        else if(theme.equals("Config Wizard Theme")) {
            currentCustomization = Config.retrieveConfigurationWizardCustomization();
        }
        else if(theme.equals("Pseudo-Fullscreen")) {
            int primaryColor = Color.parseColor("#2B2B2B"); // black
            int secondaryColor = Color.parseColor("#3BC371"); // green
            int backgroundColor = Color.parseColor("#EEF6F8"); // white
            int buttonBackgroundDisabledColor = Color.parseColor("#adadad");

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = backgroundColor;
            currentCustomization.getOverlayCustomization().showBrandingImage = false;
            currentCustomization.getOverlayCustomization().brandingImage = 0;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().subtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#565656");
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = buttonBackgroundDisabledColor;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 0;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 30;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#00EEF6F8");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 10;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 2000;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = true;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_shutter_offblack;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenDocumentImage = true;
            currentCustomization.getIdScanCustomization().selectionScreenDocumentImage = R.drawable.document_offblack;
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = Color.parseColor("#565656");
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().subtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#565656");
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = buttonBackgroundDisabledColor;
            currentCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 0;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 30;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_black;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_black;
            // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = 0;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 800;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = R.drawable.pseudo_fullscreen_animated_activity_indicator;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = secondaryColor;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage =0;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = R.drawable.pseudo_fullscreen_animated_success;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = R.drawable.pseudo_fullscreen_animated_unsuccess;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = R.drawable.pseudo_fullscreen_static_success_vector_drawable;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = R.drawable.pseudo_fullscreen_static_unsuccess_vector_drawable;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = true;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#332B2B2B");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = secondaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 1.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = secondaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getFeedbackCustomization().cornerRadius = 5;
            currentCustomization.getFeedbackCustomization().elevation = 10;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = primaryColor;
            currentCustomization.getFrameCustomization().borderWidth = 0;
            currentCustomization.getFrameCustomization().cornerRadius = 0;
            currentCustomization.getFrameCustomization().elevation = 0;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BF3BC371");
            currentCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BF3BC371");
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_offblack;
            currentCustomization.getCancelButtonCustomization().setLocation(FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM);
            currentCustomization.getCancelButtonCustomization().setCustomLocation(new Rect(10, 10, 25, 25));

            // Guidance Customization -- Text Style Overrides
            // Ready Screen Header
            currentCustomization.getGuidanceCustomization().readyScreenHeaderFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().readyScreenHeaderTextColor = primaryColor;
            // Ready Screen Subtext
            currentCustomization.getGuidanceCustomization().readyScreenSubtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = Color.parseColor("#565656");
            // Ready Screen Header
            currentCustomization.getGuidanceCustomization().retryScreenHeaderFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().retryScreenHeaderTextColor = primaryColor;
            // Retry Screen Subtext
            currentCustomization.getGuidanceCustomization().retryScreenSubtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().retryScreenSubtextTextColor = Color.parseColor("#565656");
        }
        else if(theme.equals("Well-Rounded")) {
            int primaryColor = Color.parseColor("#09B5A3"); // green
            int buttonTextDisabledColor = Color.parseColor("#d7d7d7"); // green
            int buttonBackgroundDisabledColor = Color.parseColor("#94b8b4"); // green

            int backgroundColor = Color.WHITE;

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = Color.TRANSPARENT;
            currentCustomization.getOverlayCustomization().showBrandingImage = false;
            currentCustomization.getOverlayCustomization().brandingImage = 0;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#31DDCC");
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = buttonTextDisabledColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = buttonBackgroundDisabledColor;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 0;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 30;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4D09B5A3");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 10;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = new int[0];
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 1500;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = true;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_green;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenDocumentImage = true;
            currentCustomization.getIdScanCustomization().selectionScreenDocumentImage = R.drawable.document_green;
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#31DDCC");
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = buttonTextDisabledColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = buttonBackgroundDisabledColor;
            currentCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 0;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 30;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_black;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_black;
            // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = 0;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 1000;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = R.drawable.well_rounded_animated_activity_indicator;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = Color.TRANSPARENT;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = R.drawable.well_rounded_animated_success;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = R.drawable.well_rounded_animated_unsuccess;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = R.drawable.well_rounded_static_success_vector_drawable;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = R.drawable.well_rounded_static_unsuccess_vector_drawable;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = false;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33000000");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 2.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = primaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getFeedbackCustomization().cornerRadius = 5;
            currentCustomization.getFeedbackCustomization().elevation = 5;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = primaryColor;
            currentCustomization.getFrameCustomization().borderWidth = 2;
            currentCustomization.getFrameCustomization().cornerRadius = 20;
            currentCustomization.getFrameCustomization().elevation = 10;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = primaryColor;
            currentCustomization.getOvalCustomization().progressColor2 = primaryColor;
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_round_green;
            currentCustomization.getCancelButtonCustomization().setLocation(FaceTecCancelButtonCustomization.ButtonLocation.TOP_LEFT);
        }
        else if(theme.equals("Bitcoin Exchange")) {
            int primaryColor = Color.parseColor("#F79634"); // orange
            int secondaryColor = Color.parseColor("#FFFF1E"); // yellow
            int backgroundColor = Color.parseColor("#424242"); // dark grey
            int buttonTextDisabledColor = Color.parseColor("#757575");
            int buttonBackgroundDisabledColor = Color.parseColor("#bfae9c");

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = Color.TRANSPARENT;
            currentCustomization.getOverlayCustomization().showBrandingImage = true;
            currentCustomization.getOverlayCustomization().brandingImage = R.drawable.bitcoin_exchange_logo;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = buttonTextDisabledColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = buttonBackgroundDisabledColor;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 0;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DF79634");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = new int[0];
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 1500;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = true;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_orange;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenDocumentImage = true;
            currentCustomization.getIdScanCustomization().selectionScreenDocumentImage = R.drawable.document_orange;
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = buttonTextDisabledColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = buttonBackgroundDisabledColor;
            currentCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 0;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 5;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 0;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 8;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 0;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 8;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_orange;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_orange;
            // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = R.drawable.activity_indicator_orange;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 1500;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = 0;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = 0;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = 0;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = 0;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = true;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33000000");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 1.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = primaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getFeedbackCustomization().cornerRadius = 5;
            currentCustomization.getFeedbackCustomization().elevation = 10;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderWidth = 2;
            currentCustomization.getFrameCustomization().cornerRadius = 5;
            currentCustomization.getFrameCustomization().elevation = 10;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = secondaryColor;
            currentCustomization.getOvalCustomization().progressColor2 = secondaryColor;
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_orange;
            currentCustomization.getCancelButtonCustomization().setLocation(FaceTecCancelButtonCustomization.ButtonLocation.TOP_LEFT);

            // Guidance Customization -- Text Style Overrides
            // Ready Screen Header
            currentCustomization.getGuidanceCustomization().readyScreenHeaderFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().readyScreenHeaderTextColor = primaryColor;
            // Ready Screen Subtext
            currentCustomization.getGuidanceCustomization().readyScreenSubtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = secondaryColor;
            // Retry Screen Header
            currentCustomization.getGuidanceCustomization().retryScreenHeaderFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().retryScreenHeaderTextColor = primaryColor;
            // Retry Screen Subtext
            currentCustomization.getGuidanceCustomization().retryScreenSubtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().retryScreenSubtextTextSize = 12;
            currentCustomization.getGuidanceCustomization().retryScreenSubtextTextColor = secondaryColor;

        }
        else if(theme.equals("eKYC")) {
            int primaryColor = Color.parseColor("#ED1C24"); // red
            int secondaryColor = Color.BLACK;
            int backgroundColor = Color.WHITE;
            int buttonTextDisabledColor = Color.parseColor("#ed1c24");

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = Color.TRANSPARENT;
            currentCustomization.getOverlayCustomization().showBrandingImage = true;
            currentCustomization.getOverlayCustomization().brandingImage = R.drawable.ekyc_logo;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = secondaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = null;
            currentCustomization.getGuidanceCustomization().subtextFont = null;
            currentCustomization.getGuidanceCustomization().buttonFont = null;
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = buttonTextDisabledColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 8;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DED1C24");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 3;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 3;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 1500;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = true;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_red;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenDocumentImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenDocumentImage = 0;
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = secondaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageFont = null;
            currentCustomization.getIdScanCustomization().headerFont = null;
            currentCustomization.getIdScanCustomization().subtextFont = null;
            currentCustomization.getIdScanCustomization().buttonFont = null;
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = Color.TRANSPARENT;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = buttonTextDisabledColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 2;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 8;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 0;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 0;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 2;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_black;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_black;
            // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = secondaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = null;
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = 0;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 1500;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = R.drawable.ekyc_animated_activity_indicator;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = Color.TRANSPARENT;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = Color.TRANSPARENT;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = R.drawable.ekyc_success_vector_drawable;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = R.drawable.ekyc_unsuccess_vector_drawable;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = R.drawable.ekyc_static_success_vector_drawable;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = R.drawable.ekyc_static_unsuccess_vector_drawable;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = false;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33000000");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 1.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = secondaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = null;
            currentCustomization.getFeedbackCustomization().cornerRadius = 3;
            currentCustomization.getFeedbackCustomization().elevation = 10;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = primaryColor;
            currentCustomization.getFrameCustomization().borderWidth = 2;
            currentCustomization.getFrameCustomization().cornerRadius = 8;
            currentCustomization.getFrameCustomization().elevation = 10;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BFED1C24");
            currentCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BFED1C24");
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_box_red;
            currentCustomization.getCancelButtonCustomization().setLocation(FaceTecCancelButtonCustomization.ButtonLocation.TOP_RIGHT);
        }
        else if(theme.equals("Sample Bank")) {
            int primaryColor = Color.parseColor("#FFFFFF"); // white
            int backgroundColor = Color.parseColor("#1D174F"); // navy
            int buttonTextDisabledColor = Color.parseColor("#1d174f");

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = Color.TRANSPARENT;
            currentCustomization.getOverlayCustomization().showBrandingImage = true;
            currentCustomization.getOverlayCustomization().brandingImage = R.drawable.sample_bank_logo;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BFFFFFFF");
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = buttonTextDisabledColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 2;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DFFFFFF");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 2;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 1500;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = false;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_white_navy;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenDocumentImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenDocumentImage = 0;
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BFFFFFFF");
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = buttonTextDisabledColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 2;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 2;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 2;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_white;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_white;
            // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = R.drawable.activity_indicator_white;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 1000;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = Color.TRANSPARENT;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = R.drawable.reticle_white;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = R.drawable.reticle_white;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = 0;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = 0;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = 0;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = 0;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = true;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33FFFFFF");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 1.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = primaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getFeedbackCustomization().cornerRadius = 2;
            currentCustomization.getFeedbackCustomization().elevation = 0;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = primaryColor;
            currentCustomization.getFrameCustomization().borderWidth = 2;
            currentCustomization.getFrameCustomization().cornerRadius = 2;
            currentCustomization.getFrameCustomization().elevation = 0;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BFFFFFFF");
            currentCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BFFFFFFF");
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_white;
            currentCustomization.getCancelButtonCustomization().setLocation(FaceTecCancelButtonCustomization.ButtonLocation.TOP_LEFT);
        }

        return currentCustomization;
    }

    static FaceTecCustomization getLowLightCustomizationForTheme(Context context, String theme) {
        FaceTecCustomization currentLowLightCustomization = getCustomizationForTheme(context, theme);

        int[] retryScreenSlideshowImages = new int[]{R.drawable.ideal_image_1, R.drawable.ideal_image_2, R.drawable.ideal_image_3, R.drawable.ideal_image_4, R.drawable.ideal_image_5};

        if(theme.equals("FaceTec Theme")) {
            currentLowLightCustomization = null;
        }
        else if(theme.equals("Config Wizard Theme")) {
            currentLowLightCustomization = null;
        }
        else if(theme.equals("Pseudo-Fullscreen")) {
            currentLowLightCustomization = null;
        }
        else if(theme.equals("Well-Rounded")) {
            currentLowLightCustomization = null;
        }
        else if(theme.equals("Bitcoin Exchange")) {
            int primaryColor = Color.parseColor("#F79634"); // orange
            int secondaryColor = Color.parseColor("#FFFF1E"); // yellow
            int backgroundColor = Color.parseColor("#424242"); // dark grey

            // Overlay Customization
            currentLowLightCustomization.getOverlayCustomization().brandingImage = R.drawable.bitcoin_exchange_logo;
            // Guidance Customization
            currentLowLightCustomization.getGuidanceCustomization().foregroundColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextNormalColor = Color.WHITE;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextHighlightColor = Color.WHITE;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextDisabledColor = Color.WHITE;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentLowLightCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DF79634");
            currentLowLightCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = Color.WHITE;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenSlideshowImages = new int[0];
            // ID Scan Customization
            currentLowLightCustomization.getIdScanCustomization().selectionScreenDocumentImage = R.drawable.document_grey;
            currentLowLightCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentLowLightCustomization.getIdScanCustomization().captureScreenForegroundColor = Color.WHITE;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenForegroundColor = Color.WHITE;
            currentLowLightCustomization.getIdScanCustomization().selectionScreenForegroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().buttonTextNormalColor = Color.WHITE;
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().buttonTextHighlightColor = Color.WHITE;
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().buttonTextDisabledColor = Color.WHITE;
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = Color.TRANSPARENT;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = Color.TRANSPARENT;
            currentLowLightCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_orange;
            currentLowLightCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_orange;
            // Result Screen Customization
            currentLowLightCustomization.getResultScreenCustomization().foregroundColor = backgroundColor;
            currentLowLightCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorImage = R.drawable.activity_indicator_orange;
            currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = 0;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = primaryColor;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationForegroundColor = Color.WHITE;
            currentLowLightCustomization.getResultScreenCustomization().customResultAnimationSuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33000000");
            currentLowLightCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            // Feedback Customization
            currentLowLightCustomization.getFeedbackCustomization().backgroundColors = primaryColor;
            currentLowLightCustomization.getFeedbackCustomization().textColor = Color.WHITE;
            // Frame Customization
            currentLowLightCustomization.getFrameCustomization().borderColor = backgroundColor;
            // Oval Customization
            currentLowLightCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentLowLightCustomization.getOvalCustomization().progressColor1 = secondaryColor;
            currentLowLightCustomization.getOvalCustomization().progressColor2 = secondaryColor;
            // Cancel Button Customization
            currentLowLightCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_orange;

            // Guidance Customization -- Text Style Overrides
            // Ready Screen Header
            currentLowLightCustomization.getGuidanceCustomization().readyScreenHeaderTextColor = primaryColor;
            // Ready Screen Subtext
            currentLowLightCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = backgroundColor;
            // Retry Screen Header
            currentLowLightCustomization.getGuidanceCustomization().retryScreenHeaderTextColor = primaryColor;
            // Retry Screen Subtext
            currentLowLightCustomization.getGuidanceCustomization().retryScreenSubtextTextColor = backgroundColor;
        }
        else if(theme.equals("eKYC")) {
            currentLowLightCustomization = null;
        }
        else if(theme.equals("Sample Bank")) {
            int primaryColor = Color.WHITE;
            int backgroundColor = Color.parseColor("#1D174F"); // navy

            // Overlay Customization
            currentLowLightCustomization.getOverlayCustomization().brandingImage = R.drawable.sample_bank_logo;
            // Guidance Customization
            currentLowLightCustomization.getGuidanceCustomization().foregroundColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextNormalColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextHighlightColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BF1D174F");
            currentLowLightCustomization.getGuidanceCustomization().buttonTextDisabledColor = Color.parseColor("#4DFFFFFF");
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBorderColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4D1D174F");
            currentLowLightCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenImageBorderColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            // ID Scan Customization
            currentLowLightCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentLowLightCustomization.getIdScanCustomization().captureScreenForegroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenForegroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().selectionScreenForegroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().buttonTextNormalColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundNormalColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().buttonTextHighlightColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BF1D174F");
            currentLowLightCustomization.getIdScanCustomization().buttonTextDisabledColor = Color.parseColor("#4DFFFFFF");
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().buttonBorderColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_navy;
            currentLowLightCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_navy;
            // Result Screen Customization
            currentLowLightCustomization.getResultScreenCustomization().foregroundColor = backgroundColor;
            currentLowLightCustomization.getResultScreenCustomization().activityIndicatorColor = backgroundColor;
            currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorImage = R.drawable.activity_indicator_navy;
            currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = 0;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = Color.TRANSPARENT;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = R.drawable.reticle_navy;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = R.drawable.reticle_navy;
            currentLowLightCustomization.getResultScreenCustomization().customResultAnimationSuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33000000");
            currentLowLightCustomization.getResultScreenCustomization().uploadProgressFillColor = backgroundColor;
            // Feedback Customization
            currentLowLightCustomization.getFeedbackCustomization().backgroundColors = backgroundColor;
            currentLowLightCustomization.getFeedbackCustomization().textColor = primaryColor;
            // Frame Customization
            currentLowLightCustomization.getFrameCustomization().borderColor = backgroundColor;
            // Oval Customization
            currentLowLightCustomization.getOvalCustomization().strokeColor = backgroundColor;
            currentLowLightCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BF1D174F");
            currentLowLightCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BF1D174F");
            // Cancel Button Customization
            currentLowLightCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_navy;
        }

        return currentLowLightCustomization;
    }

    static FaceTecCustomization getDynamicDimmingCustomizationForTheme(Context context, String theme) {
        FaceTecCustomization currentDynamicDimmingCustomization = getCustomizationForTheme(context, theme);

        int[] retryScreenSlideshowImages = new int[]{R.drawable.ideal_image_1, R.drawable.ideal_image_2, R.drawable.ideal_image_3, R.drawable.ideal_image_4, R.drawable.ideal_image_5};

        if(theme.equals("FaceTec Theme")) {
            currentDynamicDimmingCustomization = null;
        }
        else if(theme.equals("Config Wizard Theme")) {
            currentDynamicDimmingCustomization = null;
        }
        else if(theme.equals("Pseudo-Fullscreen")) {
            int primaryColor = Color.parseColor("#EEF6F8"); // white
            int secondaryColor = Color.parseColor("#3BC371"); // green
            int backgroundColor = Color.BLACK;

            // Overlay Customization
            currentDynamicDimmingCustomization.getOverlayCustomization().brandingImage = 0;
            // Guidance Customization
            currentDynamicDimmingCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.WHITE;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonTextDisabledColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = Color.parseColor("#BFEEF6F8");
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#00EEF6F8");
            currentDynamicDimmingCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            // ID Scan Customization
            currentDynamicDimmingCustomization.getIdScanCustomization().selectionScreenDocumentImage = R.drawable.document_offwhite;
            currentDynamicDimmingCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().reviewScreenForegroundColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.WHITE;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonTextDisabledColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = Color.parseColor("#BFEEF6F8");
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_offwhite;
            currentDynamicDimmingCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_offwhite;
            // Result Screen Customization
            currentDynamicDimmingCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customActivityIndicatorImage = 0;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = R.drawable.pseudo_fullscreen_animated_activity_indicator_offwhite;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = secondaryColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = 0;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customResultAnimationSuccess = R.drawable.pseudo_fullscreen_animated_success_offwhite;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = R.drawable.pseudo_fullscreen_animated_unsuccess_offwhite;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = R.drawable.pseudo_fullscreen_static_success_offwhite_vector_drawable;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = R.drawable.pseudo_fullscreen_static_unsuccess_offwhite_vector_drawable;
            currentDynamicDimmingCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#332B2B2B");
            currentDynamicDimmingCustomization.getResultScreenCustomization().uploadProgressFillColor = secondaryColor;
            // Feedback Customization
            currentDynamicDimmingCustomization.getFeedbackCustomization().backgroundColors = secondaryColor;
            currentDynamicDimmingCustomization.getFeedbackCustomization().textColor = backgroundColor;
            // Frame Customization
            currentDynamicDimmingCustomization.getFrameCustomization().borderColor = primaryColor;
            // Oval Customization
            currentDynamicDimmingCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentDynamicDimmingCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BF3BC371");
            currentDynamicDimmingCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BF3BC371");
            // Cancel Button Customization
            currentDynamicDimmingCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_offwhite;

            // Guidance Customization -- Text Style Overrides
            // Ready Screen Header
            currentDynamicDimmingCustomization.getGuidanceCustomization().readyScreenHeaderTextColor = primaryColor;
            // Ready Screen Subtext
            currentDynamicDimmingCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = primaryColor;
            // Ready Screen Header
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenHeaderTextColor = primaryColor;
            // Retry Screen Subtext
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenSubtextTextColor = primaryColor;
        }
        else if(theme.equals("Well-Rounded")) {
            currentDynamicDimmingCustomization = null;
        }
        else if(theme.equals("Bitcoin Exchange")) {
            currentDynamicDimmingCustomization = null;
        }
        else if(theme.equals("eKYC")) {
            int primaryColor = Color.parseColor("#ED1C24"); // red
            int secondaryColor = Color.WHITE;
            int backgroundColor = Color.BLACK;

            // Overlay Customization
            currentDynamicDimmingCustomization.getOverlayCustomization().brandingImage = R.drawable.ekyc_logo;
            // Guidance Customization
            currentDynamicDimmingCustomization.getGuidanceCustomization().foregroundColor = secondaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonTextNormalColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonTextDisabledColor = Color.parseColor("#4DED1C24");
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getGuidanceCustomization().buttonBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DED1C24");
            currentDynamicDimmingCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentDynamicDimmingCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            // ID Scan Customization
            currentDynamicDimmingCustomization.getIdScanCustomization().selectionScreenDocumentImage = 0;
            currentDynamicDimmingCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenForegroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().reviewScreenForegroundColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = secondaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonTextNormalColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBackgroundNormalColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonTextDisabledColor = Color.parseColor("#4DED1C24");
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getIdScanCustomization().buttonBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentDynamicDimmingCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_offwhite;
            currentDynamicDimmingCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_offwhite;
            // Result Screen Customization
            currentDynamicDimmingCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().foregroundColor = secondaryColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customActivityIndicatorImage = 0;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = R.drawable.ekyc_animated_activity_indicator;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationForegroundColor = Color.TRANSPARENT;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentDynamicDimmingCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = 0;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customResultAnimationSuccess = R.drawable.ekyc_success_white_vector_drawable;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = R.drawable.ekyc_unsuccess_white_vector_drawable;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = R.drawable.ekyc_static_success_white_vector_drawable;
            currentDynamicDimmingCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = R.drawable.ekyc_static_unsuccess_white_vector_drawable;
            currentDynamicDimmingCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33FFFFFF");
            currentDynamicDimmingCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            // Feedback Customization
            currentDynamicDimmingCustomization.getFeedbackCustomization().backgroundColors = secondaryColor;
            currentDynamicDimmingCustomization.getFeedbackCustomization().textColor = backgroundColor;
            // Frame Customization
            currentDynamicDimmingCustomization.getFrameCustomization().borderColor = primaryColor;
            // Oval Customization
            currentDynamicDimmingCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentDynamicDimmingCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BFED1C24");
            currentDynamicDimmingCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BFED1C24");
            // Cancel Button Customization
            currentDynamicDimmingCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_box_red;
        }
        else if(theme.equals("Sample Bank")) {
            currentDynamicDimmingCustomization = null;
        }

        return currentDynamicDimmingCustomization;
    }

}
