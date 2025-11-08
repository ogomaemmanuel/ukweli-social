import Image from "next/image";
import MainContent from "@/components/MainContent";
import TopBar from "@/components/TopBar"
import LeftSidebar from "@/components/LeftSidebar"
import RightSidebar from "@/components/RightSidebar"

export default function Home() {
    return (
        <div className="min-h-screen bg-gray-100">
            <TopBar/>
            <div className="container mx-auto px-4 py-8">
                <div className="flex flex-col lg:flex-row gap-8">
                    <LeftSidebar/>
                    <MainContent/>
                    <RightSidebar/>
                </div>
            </div>
        </div>);
}
