// Welcome to the minimized FaceTec Device SDK code to launch User Sessions and retrieve 3D FaceScans (for further processing)!
// This file removes comment annotations, as well as networking calls,
// in an effort to demonstrate how little code is needed to get the FaceTec Device SDKs to work.

// NOTE: This example DOES NOT perform a Liveness Check.  To perform the Liveness Check, you need to actually make an API call.
// Please see the LivenessCheckProcessor file for a complete demonstration using the FaceTec Testing API.

package Processors_min_no_networking;

import android.content.Context;
import android.util.Log;

import com.facetec.sdk.FaceTecFaceScanProcessor;
import com.facetec.sdk.FaceTecFaceScanResultCallback;
import com.facetec.sdk.FaceTecSessionActivity;
import com.facetec.sdk.FaceTecSessionResult;
import com.facetec.sdk.FaceTecSessionStatus;

import org.json.JSONException;
import org.json.JSONObject;

public class LivenessCheckProcessor_min_no_networking implements FaceTecFaceScanProcessor {
    public LivenessCheckProcessor_min_no_networking(final Context context, String sessionToken) {
        // Core FaceTec Device SDK code that starts the User Session.
        FaceTecSessionActivity.createAndLaunchSession(context, LivenessCheckProcessor_min_no_networking.this, sessionToken);
    }

    public void processSessionWhileFaceTecSDKWaits(final FaceTecSessionResult sessionResult, final FaceTecFaceScanResultCallback faceScanResultCallback) {
        // Normally a User will complete a Session.  This checks to see if there was a cancellation, timeout, or some other non-success case.
        if(sessionResult.getStatus() != FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY) {
            faceScanResultCallback.cancel();
            return;
        }

        // IMPORTANT:  FaceTecSDK.FaceTecSessionStatus.SessionCompletedSuccessfully DOES NOT mean the Liveness Check was Successful.
        // It simply means the User completed the Session and a 3D FaceScan was created.  You still need to perform the Liveness Check on your Servers.

        // These are the core parameters
        JSONObject parameters = new JSONObject();
        try {
            parameters.put("faceScan", sessionResult.getFaceScanBase64());
            parameters.put("auditTrailImage", sessionResult.getAuditTrailCompressedBase64()[0]);
            parameters.put("lowQualityAuditTrailImage", sessionResult.getLowQualityAuditTrailCompressedBase64()[0]);
        }
        catch(JSONException e) {
            e.printStackTrace();
            Log.d("FaceTecSDKSampleApp", "Exception raised while attempting to create JSON payload for upload.");
        }

        // DEVELOPER TODOS:
        // 1.  Call your own API with the above data and pass into the Server SDK
        // 2.  If Liveness Succeeded, call succeed()
        // 3.  If Liveness Was Not Proven, the User Needs to Retry, so call retry()
        // 4.  cancel() is provided in case you detect issues with your own API
        // 5.  uploadProgress(progress) is provided to control the Progress Bar.

        // faceScanResultCallback.succeed();
        // faceScanResultCallback.retry();
        // faceScanResultCallback.cancel();
        // faceScanResultCallback.uploadProgress(yourUploadProgressFloat)

        // LAST STEP:  On Android, the onActivityResult function in your Activity will receive control after the FaceTec SDK returns.
    }
}
