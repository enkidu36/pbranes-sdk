(ns fit-sdk.listener-test
  (:require [clojure.test :refer :all]
            [fit-sdk.listener :refer :all])
  (:import (com.garmin.fit FileIdMesgListener
                           UserProfileMesgListener
                           DeviceInfoMesgListener
                           MonitoringMesgListener
                           RecordMesgListener
                           DeveloperFieldDescriptionListener )))

(deftest broadcast-listener-test
  (testing "broadcast-listener implements interfaces"
    (is (instance? FileIdMesgListener broadcast-listener ))
    (is (instance? UserProfileMesgListener broadcast-listener))
    (is (instance? DeviceInfoMesgListener broadcast-listener))
    (is (instance? MonitoringMesgListener broadcast-listener))
    (is (instance? RecordMesgListener broadcast-listener))
    (is (instance? DeviceInfoMesgListener broadcast-listener))))


;(defn file-id-mesg-factory [file-type]
;  (let [mesg (new FileIdMesg)]
;    (when (boolean file-type)
;      (.setType mesg file-type))
;    mesg))
;
;(defn client []
;  (let
;    [listener broadcast-listener]
;    (do
;      (.onMesg listener (file-id-mesg-factory nil))
;      (.onMesg listener (UserProfileMesg.))
;      (.onMesg listener (DeviceInfoMesg.))
;      (.onMesg listener (RecordMesg.)))))